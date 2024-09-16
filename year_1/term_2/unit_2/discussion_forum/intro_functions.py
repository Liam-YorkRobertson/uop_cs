# creating simple python functions
# note that we are using interactive mode for this, so these functions are just copies of functions created in the terminal
 

# example 1
def my_printing_function(arg1):
    print(arg1)
    
my_printing_function(22)
    
# example 2
my_printing_function(14)
age = 22
my_printing_function(age)
my_printing_function(age + 64)

# example 3
def list_of_values():
    value1 = 35
    print(value1)
    
list_of_values()
print(value1) # this is to explain that value1 is a local variable in list_of_values

# example 4 
def print_band_name(band):
    print(band)

print_band_name("Slipknot")
print(band) # explain what happens when parameter name used out of function

# example 5 (checking what happens when global and local variables have same name)
def exponentiation():
    value1 = 5
    print(value1 ** 2)

exponentiation()
value1 = 8
exponentiation()
