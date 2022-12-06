def check_if_all_characters_different(string):
    for i in range(len(string) - 1):
        for j in range(i + 1, len(string)):
            if string[i] == string[j]:
                return False
    return True


def get_list_form_file(file):
    my_file = open(file, "r")
    data = my_file.read()
    my_file.close()
    return data.split("\n")


line = get_list_form_file("input.txt")[0]
section_length = 14
position = section_length
starter_package_found = False
while not starter_package_found:
    if check_if_all_characters_different(line[position - section_length:position]):
        starter_package_found = True
    else:
        position += 1
print(position)