# creating fruitful functions with incremental development strategy

import math

def volume_of_cylinder(radius, height):
    """calculates volume of a cylinder

    Args:
        radius (float): radius of cylinder
        height (float): height of cylinder

    Returns:
        float: volume of cylinder
    """
    # calculate volume
    volume = math.pi * (radius ** 2) * height
    # returns volume
    return(volume)