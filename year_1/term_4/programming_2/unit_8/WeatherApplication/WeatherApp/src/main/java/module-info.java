module liamyorkrobertson.weatherapp {
    requires java.net.http;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    
    opens liamyorkrobertson.weatherapp to javafx.fxml;
    exports liamyorkrobertson.weatherapp;
}
