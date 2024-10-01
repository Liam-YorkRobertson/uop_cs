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
    # prints arguments provided before calculation
    print(radius, height)
    
    # tests if radius is a floating-point number
    try:
        radius = float(radius)
    except (ValueError, NameError):
        print("radius must be a floating-point number")
        return None
    # if radius is a floating-point number then it is printed
    print("the value of radius is:", radius)
    
    # tests if height is a floating-point number
    try:
        height = float(height)
    except (ValueError, NameError):
        print("height must be a floating-point number")
        return None
    # if height is a floating-point number then it is printed
    print("the value of height is:", height)
    
    # calculation of volume of cylinder
    volume = math.pi * (radius ** 2) * height
    
    # displays volume to user
    print("the volume of a cylinder with a radius of", radius, "and a height of", height, "is", volume)
    
    # returns volume for future use
    return(volume)

# executes volume_of_cylinder when script is run to test
volume_of_cylinder(4, 5)