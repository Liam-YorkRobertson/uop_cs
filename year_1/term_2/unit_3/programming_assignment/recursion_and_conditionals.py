# workign with recursion and conditionals

# countdown function from section 5.8 of textbook
def countdown(n): 
    if n <= 0: 
        print('Blastoff!') 
    else: 
        print(n) 
        countdown(n-1)
        
# countup function
def countup(n):
    if n >= 0:
        print("Blastoff!")
    else:
        print(n)
        countup(n+1)
        
# count_down_or_up function
def count_down_or_up():
    count = int(input("Please insert a negative or positive number: "))
    if count > 0:
        countdown(count)
    elif count < 0:
        countup(count)
    else:
        countdown(count)
     
# function to demonstrate error when dividing by 0   
def my_division():
    dividend = float(input("Insert the dividend: "))
    divisor = float(input("Insert the divisor: "))
    if divisor != 0:
        quotient = dividend / divisor
        print("The quotient of the division is", end=" ")
        print(quotient)
    else:
        raise RuntimeError("Division by 0 is not allowed in Python")

