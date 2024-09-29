# creating erroneous functions to demonstrate bugs

# function that receives correct arguments, but the multiplication
# calculation syntax is incorrect
def my_multiplication(num1, num2):
    """function that returns product of two numbers

    Args:
        num1 (int): multiplier
        num2 (int): multiplicand
    """
    result = num1 *** num2
    print(result)

my_multiplication(4, 6)