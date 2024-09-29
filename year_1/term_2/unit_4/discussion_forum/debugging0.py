# creating erroneous functions to demonstrate bugs

# function that expects int args, but will recieve str args
def my_division(num1, num2):
    """function that returns quotient of two numbers

    Args:
        num1 (int): dividend
        num2 (int): divisor
    """
    result = num1 / num2
    print(result)

my_division("hello", "world")