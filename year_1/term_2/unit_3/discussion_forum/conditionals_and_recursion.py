# working with conditionals and recursion

# chained conditional 
hemisphere = input("Which hemisphere do you live in? Choose 'north' or 'south' \n")
if hemisphere == "north":
    print("It is currently Autumn in your region.")
elif hemisphere == "south":
    print("It is currently Spring in your region.")
else:
    print("Do you live on Mars?!")
    
# nested conditional
american = input("Are you American? 'yes' or 'no' \n")
age = int(input("What is your age? \n"))
if american == "yes":
    if age >= 21:
        print("You may purchase alcohol through this site")
    else:
        print("You may not purchase alcohol through this site.")
elif american == "no":
    if age >= 18:
        print("You may purchase alcohol through this site")
    else:
        print("You may not purchase alcohol through this site.")
else:
    print("Follow the instructions")
        
# nested conditional that can be simplified (made it shorter)
weight = float(input("Insert your weight in kilograms: \n"))
if weight > 40:
    if weight < 100:
        print("You may get on this ride")
    
# simplified confitional with logical operators
weight = float(input("Insert your weight in kilograms: \n"))
if weight > 40 and weight < 100:
        print("You may get on this ride")