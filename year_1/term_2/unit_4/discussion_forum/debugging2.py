# creating erroneous functions to demonstrate bugs

# function that returns a value, but the return is not used
def my_exponentiation(num1, num2):
    """function that returns power of two numbers

    Args:
        num1 (int): base
        num2 (int): exponent
    """
    power = num1 ** num2
    return power

print("This is the result: " + my_exponentiation(4, 3))