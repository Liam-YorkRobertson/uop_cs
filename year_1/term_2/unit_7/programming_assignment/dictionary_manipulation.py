# manipulating dictionaries in python

def inverse_dictionary():
    """
    function that creates a dictionary, and then inverts it
    """
    #creates and prints the original dictionary
    student_courses = dict()
    student_courses['Stud1'] = ['CS1101', 'CS2402', 'CS2001']
    student_courses['Stud2'] = ['CS2402','CS2001','CS1102']
    print("Dictionary:")
    print(student_courses)
    
    #inverts dictionary and prints it
    courses_student = dict()
    for key, values in student_courses.items():
        for value in values:
            if value not in courses_student:
                courses_student[value] = [key]
            else:
                courses_student[value].append(key)
    print("Inverted dictionary:")
    print(courses_student)