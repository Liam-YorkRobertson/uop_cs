package liamyorkrobertson.weatherapp;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.net.*;
import java.net.http.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import org.json.*;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Controller class for the Weather Application.
 * Handles user interactions, fetches weather data from the OpenWeatherMap API,
 * and updates the UI with the retrieved data.
 * 
 * @author Liam-York Robertson
 */
public class WeatherController {

    @FXML private ImageView backgroundImageView;
    @FXML private ToggleGroup areaToggleGroup;
    @FXML private TextField locationTextField;
    @FXML private SplitMenuButton temperatureSplitMenu, windSpeedSplitMenu;
    @FXML private Label temperatureLabel, humidityLabel, windSpeedLabel, conditionLabel;
    @FXML private ImageView weatherImageView;
    @FXML private Button fetchWeatherButton;
    @FXML private Label tVar1, hVar1, wVar1, cVar1, dateVar1;
    @FXML private Label tVar2, hVar2, wVar2, cVar2, dateVar2;
    @FXML private Label tVar3, hVar3, wVar3, cVar3, dateVar3;
    @FXML private ImageView weatherIcon1, weatherIcon2, weatherIcon3;
    @FXML private Label historyDateVar1, historyTimeVar1, historyCityVar1, historyCoordVar1;
    @FXML private Label historyDateVar2, historyTimeVar2, historyCityVar2, historyCoordVar2;
    @FXML private Label historyDateVar3, historyTimeVar3, historyCityVar3, historyCoordVar3;
    @FXML private Label historyDateVar4, historyTimeVar4, historyCityVar4, historyCoordVar4;
    @FXML private Label historyDateVar5, historyTimeVar5, historyCityVar5, historyCoordVar5;

    private double rawTemperature, rawWindSpeed;
    private double rawForecastTemp1, rawForecastTemp2, rawForecastTemp3;
    private double rawForecastWind1, rawForecastWind2, rawForecastWind3;
    private final Deque<String> searchHistory = new ArrayDeque<>(5);

    private static final String API_KEY = "cfa4dc1c275ded18f1e03f3c1e28bd3c";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    /**
     * Updates background image based on current time of day.
     */
    private void updateBackgroundImage() {
        int hour = LocalTime.now().getHour();
        String imagePath;
        if (hour >= 6 && hour < 12) {
            imagePath = "/images/morning.jpg";
        } else if (hour >= 12 && hour < 18) {
            imagePath = "/images/afternoon.jpg";
        } else if (hour >= 18 && hour < 21) {
            imagePath = "/images/evening.jpg";
        } else {
            imagePath = "/images/night.jpg";
        }
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl != null) {
            backgroundImageView.setImage(new Image(imageUrl.toExternalForm()));
        } else {
            System.out.println("Error: Unable to load background image from path: " + imagePath);
        }
    }

    /**
     * Initialises the controller.
     * Called automatically after FXML file has been loaded.
     */
    @FXML
    public void initialize() {
        updateBackgroundImage();
    }

    /**
     * Handles "Get Weather" button click event.
     * Fetches weather data for specified location or coordinates and updates UI.
     * 
     * @throws IOException if input/output error occurs
     * @throws InterruptedException if HTTP request is interrupted
     */
    @FXML
    private void handleGetWeather() throws IOException, InterruptedException {
        temperatureSplitMenu.setText("Fahrenheit");
        windSpeedSplitMenu.setText("mph");

        String location = locationTextField.getText().trim();
        if (location.isEmpty()) {
            showErrorAlert("Invalid Input", "Location input cannot be empty. Please enter a valid location.");
            return;
        }

        if (areaToggleGroup.getSelectedToggle() == null) {
            showErrorAlert("Selection Error", "Please select either 'Location' or 'Co-ordinates' before entering your input.");
            return;
        }

        String selectedOption = ((RadioButton) areaToggleGroup.getSelectedToggle()).getText();
        if (selectedOption.equals("Location") && location.matches(".*\\d.*")) {
            showErrorAlert("Input Mismatch", "Coordinates are not allowed when 'Location' is selected. Please enter a valid location name.");
            return;
        }
        if (selectedOption.equals("Co-ordinates") && !location.matches(".*\\d.*")) {
            showErrorAlert("Input Mismatch", "A location name is not allowed when 'Co-ordinates' is selected. Please enter valid coordinates.");
            return;
        }

        String unit = "imperial";
        String url = buildApiUrl(location, unit);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            showErrorAlert("Network Error", "Failed to connect to the weather service. Please check your internet connection.");
            return;
        }

        if (response.statusCode() == 200) {
            try {
                JSONObject jsonResponse = new JSONObject(response.body());
                JSONObject main = jsonResponse.getJSONObject("main");
                JSONObject wind = jsonResponse.getJSONObject("wind");
                JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);

                double temperature = main.getDouble("temp");
                int humidity = main.getInt("humidity");
                double windSpeed = wind.getDouble("speed");
                String condition = weather.getString("description");
                String iconCode = weather.getString("icon");

                this.rawTemperature = temperature;
                this.rawWindSpeed = windSpeed;

                updateDisplayedValues(false);
                humidityLabel.setText(humidity + " %");
                conditionLabel.setText(condition);

                Image weatherImage = new Image("https://openweathermap.org/img/wn/" + iconCode + "@2x.png");
                weatherImageView.setImage(weatherImage);

                fetchWeatherForecast(location, unit);

                String cityName = jsonResponse.getString("name");
                String coordinates = jsonResponse.getJSONObject("coord").getDouble("lat") + ", " +
                                     jsonResponse.getJSONObject("coord").getDouble("lon");
                addSearchToHistory(cityName, coordinates);
            } catch (JSONException e) {
                showErrorAlert("Data Error", "Failed to parse weather data. Please try again later.");
            }
        } else if (response.statusCode() == 404) {
            showErrorAlert("Invalid Input", "The specified location or coordinates are invalid. Please check your input.");
        } else {
            showErrorAlert("API Error", "Failed to fetch weather data. HTTP Status Code: " + response.statusCode());
        }
    }

    /**
     * Adds search entry to history and updates history panes.
     * 
     * @param cityName name of city
     * @param coordinates coordinates of location
     */
    private void addSearchToHistory(String cityName, String coordinates) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String date = LocalDateTime.now().format(dateFormatter);
        String time = LocalDateTime.now().format(timeFormatter);

        String searchEntry = String.format("%s|%s|%s|%s", date, time, cityName, coordinates);
        searchHistory.addFirst(searchEntry);

        if (searchHistory.size() > 5) searchHistory.removeLast();
        updateHistoryPanes();
    }

    /**
     * Updates history panes with latest search history.
     */
    private void updateHistoryPanes() {
        Label[][] historyLabels = {
            {historyDateVar1, historyTimeVar1, historyCityVar1, historyCoordVar1},
            {historyDateVar2, historyTimeVar2, historyCityVar2, historyCoordVar2},
            {historyDateVar3, historyTimeVar3, historyCityVar3, historyCoordVar3},
            {historyDateVar4, historyTimeVar4, historyCityVar4, historyCoordVar4},
            {historyDateVar5, historyTimeVar5, historyCityVar5, historyCoordVar5}
        };

        String[] historyArray = searchHistory.toArray(new String[0]);
        for (int i = 0; i < historyArray.length; i++) {
            String[] details = historyArray[i].split("\\|");
            for (int j = 0; j < details.length; j++) {
                historyLabels[i][j].setText(details[j]);
            }
        }
    }

    /**
     * Fetches weather forecast for specified location and updates forecast UI.
     * 
     * @param location location or coordinates to fetch forecast for
     * @param unit unit system to use
     * @throws IOException if input/output error occurs
     * @throws InterruptedException if HTTP request is interrupted
     */
    private void fetchWeatherForecast(String location, String unit) throws IOException, InterruptedException {
        String forecastUrl = "https://api.openweathermap.org/data/2.5/forecast?appid=" + API_KEY + "&units=" + unit;

        if (((RadioButton) areaToggleGroup.getSelectedToggle()).getText().equals("Location")) {
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
            forecastUrl += "&q=" + encodedLocation;
        } else {
            String[] coords = location.split(",");
            if (coords.length == 2) {
                String lat = coords[0].replaceAll("[^0-9.\\-]", "").trim();
                String lon = coords[1].replaceAll("[^0-9.\\-]", "").trim();

                if (coords[0].toUpperCase().contains("S")) lat = "-" + lat;
                if (coords[1].toUpperCase().contains("W")) lon = "-" + lon;

                forecastUrl += "&lat=" + lat + "&lon=" + lon;
            } else {
                System.out.println("Error: Invalid coordinates format.");
                showErrorAlert("Input Error", "Invalid coordinates format. Please enter valid coordinates.");
                return;
            }
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(forecastUrl)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray forecastList = jsonResponse.getJSONArray("list");

            String[] dates = new String[3];
            double[] temperatures = new double[3];
            int[] humidities = new int[3];
            double[] windSpeeds = new double[3];
            String[] conditions = new String[3];
            String[] iconCodes = new String[3];

            int dayIndex = 0;

            for (int i = 0; i < forecastList.length() && dayIndex < 3; i++) {
                JSONObject forecast = forecastList.getJSONObject(i);
                String forecastDate = forecast.getString("dt_txt");

                if (forecastDate.contains("12:00:00")) {
                    JSONObject main = forecast.getJSONObject("main");
                    JSONObject wind = forecast.getJSONObject("wind");
                    JSONObject weather = forecast.getJSONArray("weather").getJSONObject(0);

                    dates[dayIndex] = forecastDate.split(" ")[0];
                    temperatures[dayIndex] = main.getDouble("temp");
                    humidities[dayIndex] = main.getInt("humidity");
                    windSpeeds[dayIndex] = wind.getDouble("speed");
                    conditions[dayIndex] = weather.getString("description");
                    iconCodes[dayIndex] = weather.getString("icon");

                    if (dayIndex == 0) {
                        rawForecastTemp1 = temperatures[dayIndex];
                        rawForecastWind1 = windSpeeds[dayIndex];
                    } else if (dayIndex == 1) {
                        rawForecastTemp2 = temperatures[dayIndex];
                        rawForecastWind2 = windSpeeds[dayIndex];
                    } else if (dayIndex == 2) {
                        rawForecastTemp3 = temperatures[dayIndex];
                        rawForecastWind3 = windSpeeds[dayIndex];
                    }

                    dayIndex++;
                }
            }

            updateForecastUI(dates, temperatures, humidities, windSpeeds, conditions, iconCodes, unit);
        } else {
            System.out.println("Error: Unable to fetch weather forecast. HTTP Status Code: " + response.statusCode());
            showErrorAlert("API Error", "Failed to fetch weather forecast. Please check your input or try again later.");
        }
    }

    /**
     * Updates forecast UI with retrieved forecast data.
     * 
     * @param dates forecast dates
     * @param temperatures forecast temperatures
     * @param humidities forecast humidity levels
     * @param windSpeeds forecast wind speeds
     * @param conditions forecast weather conditions
     * @param iconCodes forecast weather icon codes
     * @param unit unit system used for data
     */
    private void updateForecastUI(String[] dates, double[] temperatures, int[] humidities, double[] windSpeeds, String[] conditions, String[] iconCodes, String unit) {
        Label[][] forecastLabels = {
            {dateVar1, tVar1, hVar1, wVar1, cVar1},
            {dateVar2, tVar2, hVar2, wVar2, cVar2},
            {dateVar3, tVar3, hVar3, wVar3, cVar3}
        };
        ImageView[] forecastIcons = {weatherIcon1, weatherIcon2, weatherIcon3};

        for (int i = 0; i < dates.length; i++) {
            forecastLabels[i][0].setText(dates[i]);
            forecastLabels[i][1].setText(String.format("%.2f °%s", temperatures[i], unit.equals("metric") ? "C" : "F"));
            forecastLabels[i][2].setText(humidities[i] + " %");
            forecastLabels[i][3].setText(String.format("%.2f mph", windSpeeds[i]));
            forecastLabels[i][4].setText(conditions[i]);
            forecastIcons[i].setImage(new Image("https://openweathermap.org/img/wn/" + iconCodes[i] + "@2x.png"));
        }
    }

    /**
     * Builds API URL for fetching weather data based on specified location and unit system.
     * 
     * @param location location or coordinates
     * @param unit unit system to use
     * @return constructed API URL
     */
    private String buildApiUrl(String location, String unit) {
        String url = BASE_URL + "?appid=" + API_KEY + "&units=" + unit;
        try {
            if (((RadioButton) areaToggleGroup.getSelectedToggle()).getText().equals("Location")) {
                String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
                url += "&q=" + encodedLocation;
            } else {
                String[] coords = location.split(",");
                if (coords.length == 2) {
                    String lat = coords[0].replaceAll("[^0-9.\\-]", "").trim();
                    String lon = coords[1].replaceAll("[^0-9.\\-]", "").trim();
                    if (coords[0].contains("S")) lat = "-" + lat;
                    if (coords[1].contains("W")) lon = "-" + lon;
                    url += "&lat=" + lat + "&lon=" + lon;
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing location: " + e.getMessage());
        }
        return url;
    }

    /**
     * Handles temperature unit change event.
     * Updates displayed temperature values based on selected unit.
     * 
     * @param event action event triggered by user
     */
    @FXML
    private void handleTemperatureUnitChange(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        temperatureSplitMenu.setText(selectedItem.getText());
        updateDisplayedValues(true);
    }

    /**
     * Handles wind speed unit change event.
     * Updates displayed wind speed values based on selected unit.
     * 
     * @param event action event triggered by user
     */
    @FXML
    private void handleWindSpeedUnitChange(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        windSpeedSplitMenu.setText(selectedItem.getText());
        updateDisplayedValues(true);
    }

    /**
     * Updates displayed temperature and wind speed values.
     * Converts values to selected units if necessary.
     * 
     * @param applyConversion whether to apply unit conversion
     */
    private void updateDisplayedValues(boolean applyConversion) {
        double displayedTemperature = rawTemperature;
        double displayedWindSpeed = rawWindSpeed;
        double[] displayedForecastTemps = {rawForecastTemp1, rawForecastTemp2, rawForecastTemp3};
        double[] displayedForecastWinds = {rawForecastWind1, rawForecastWind2, rawForecastWind3};
        String temperatureUnit = "°F", windSpeedUnit = "mph";

        if (applyConversion) {
            if (temperatureSplitMenu.getText().equals("Celsius")) {
                displayedTemperature = (rawTemperature - 32) * 5 / 9;
                temperatureUnit = "°C";
                for (int i = 0; i < 3; i++) displayedForecastTemps[i] = (displayedForecastTemps[i] - 32) * 5 / 9;
            }
            if (windSpeedSplitMenu.getText().equals("Kph")) {
                displayedWindSpeed = rawWindSpeed * 1.60934;
                windSpeedUnit = "kph";
                for (int i = 0; i < 3; i++) displayedForecastWinds[i] *= 1.60934;
            }
        }

        temperatureLabel.setText(String.format("%.2f %s", displayedTemperature, temperatureUnit));
        windSpeedLabel.setText(String.format("%.2f %s", displayedWindSpeed, windSpeedUnit));

        Label[] tempLabels = {tVar1, tVar2, tVar3};
        Label[] windLabels = {wVar1, wVar2, wVar3};
        for (int i = 0; i < 3; i++) {
            tempLabels[i].setText(String.format("%.2f %s", displayedForecastTemps[i], temperatureUnit));
            windLabels[i].setText(String.format("%.2f %s", displayedForecastWinds[i], windSpeedUnit));
        }
    }

    /**
     * Displays error alert with specified title and message.
     * 
     * @param title title of alert
     * @param message message to display in alert
     */
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}