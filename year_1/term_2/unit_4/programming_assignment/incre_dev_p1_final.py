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
    # calculate hypotenuse
    hypotenuse_length = math.sqrt((side1 ** 2) + (side2 ** 2))
    # return hypotenuse for future use
    return(hypotenuse_length)