# working with files in python

def file_dict():
    """
    get dict from file, then invert dict, then write dict to new file 
    """
    samp_dict = dict()
    # read from file
    with open("sample_dict.txt", "r") as rf:
        for line in rf:
            # removes whitespace and newline characters
            line = line.strip()
            # skips { and } characters
            if line not in ["{", "}"]:
                # assigns key to string before : and value to string after : 
                key = line.split(":")[0].strip()
                value = line.split(":")[-1].strip()
                # if , is present create list, otherwise create single-item list 
                if "," in value:
                    value_list = []
                    for values in value.split(","):
                        value_list.append(values.strip())
                    value = value_list
                else:
                    value = [value]
                # add key value pair to samp_dict
                samp_dict[key] = value
                
    print("Original dictionary:\n", samp_dict)      
    
    inverted_samp_dict = dict()
    #inverting dictionary
    for inv_key, inv_values in samp_dict.items():
        for inv_value in inv_values:
            if inv_value not in inverted_samp_dict:
                inverted_samp_dict[inv_value] = [inv_key]
            else:
                inverted_samp_dict[inv_value].append(inv_key)
                
    print("Inverted dictionary:\n", inverted_samp_dict)
    # write to new file
    with open("inverted_sample_dict.txt", "w") as wf:
        # reformatting dict to meet desired output
        wf.write("{\n")
        for key, value in inverted_samp_dict.items():
            # convert list of values into , separated string
            reformatted_value = ", ".join(value)
            # write formatted key-value pair to output file
            wf.write(key + ": " + reformatted_value +"\n")
        wf.write("}")