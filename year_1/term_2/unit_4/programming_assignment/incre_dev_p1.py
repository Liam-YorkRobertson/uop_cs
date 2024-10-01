# creating fruitful functions with incremental development strategy

import math

def hypotenuse(side1, side2):
    """calculates the hypotenuse of a triangle

    Args:
        side1 (float): one side of the triangle
        side2 (float): other side of the triangle
    
    Returns:
        float: length of hypotenuse
    """
    # prints sides provided before calculation
    print(side1, side2)
    
    # checks if side1 is a floating-point number
    try:
        side1 = float(side1)
    except (ValueError, NameError):
        print("side1 must be a floating-point number!")
        return None
    # if side 1 is a floating point number then it is printed
    print("the value of side1 is:", side1)
    
    # checks if side2 is a floating-point number
    try:
        side2 = float(side2)
    except (ValueError, NameError):
            print("side2 must be a floating-point number!")
            return None
    # if side 2 is a floating point number then it is printed
    print("the value of side2 is:", side2)
    
    # calculates hypotenuse and prints it to output
    hypotenuse_length = math.sqrt((side1 ** 2) + (side2 ** 2))
    print("the hypotenuse of the triangle is:", hypotenuse_length)
    
    # returns hypotenuse for future use 
    return(hypotenuse_length)
    
# test running function
hypotenuse(3,4)