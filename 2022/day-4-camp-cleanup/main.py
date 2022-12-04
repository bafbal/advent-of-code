import re


def get_number_of_fully_overlapping_pairs(file, check_type):
    lines = get_list_form_file(file)
    total_overlapping_pairs = 0
    for line in lines:
        numbers = split_string_by_dashes_and_commas(line)
        if check_type(numbers):
            total_overlapping_pairs += 1
    return total_overlapping_pairs


def get_list_form_file(file):
    my_file = open(file, "r")
    data = my_file.read()
    my_file.close()
    return data.split("\n")


def split_string_by_dashes_and_commas(string):
    return re.split("[,\-]+", string)


def check_for_full_overlapping(numbers):
    return int(numbers[0]) <= int(numbers[2]) and int(numbers[1]) >= int(numbers[3])\
           or int(numbers[2]) <= int(numbers[0]) and int(numbers[3]) >= int(numbers[1])


def check_for_partial_overlapping(numbers):
    return int(numbers[1]) >= int(numbers[2]) and int(numbers[0]) <= int(numbers[3])\
           or int(numbers[3]) >= int(numbers[0]) and int(numbers[1]) >= int(numbers[2])


if __name__ == '__main__':
    print(get_number_of_fully_overlapping_pairs("input.txt", check_for_full_overlapping))
