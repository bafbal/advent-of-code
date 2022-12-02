def rps_pt1(file):
    rounds = get_list_form_file(file)
    points_of_outcomes = get_points_of_outcomes()
    points_of_selected_shape = get_points_of_selected_shape()

    total_point = 0
    for round in rounds:
        total_point += points_of_outcomes[round]
        total_point += points_of_selected_shape[round[2]]

    print(total_point)


def rps_pt2(file):
    rounds = get_list_form_file(file)
    points_of_outcomes = get_points_of_outcomes()
    points_of_selected_shape = get_points_of_selected_shape()
    decyphering_map = decypher_secret_strategy()

    total_point = 0
    for round in rounds:
        actual_round = decyphering_map[round]
        total_point += points_of_outcomes[actual_round]
        total_point += points_of_selected_shape[actual_round[2]]

    print(total_point)


def get_list_form_file(file):
    my_file = open(file, "r")
    data = my_file.read()
    my_file.close()
    return data.split("\n")


def get_points_of_outcomes():
    return {
        "A X": 3,
        "A Y": 6,
        "A Z": 0,
        "B X": 0,
        "B Y": 3,
        "B Z": 6,
        "C X": 6,
        "C Y": 0,
        "C Z": 3
    }


def get_points_of_selected_shape():
    return {
        "X": 1,
        "Y": 2,
        "Z": 3
    }


def decypher_secret_strategy():
    return {
        "A X": "A Z",
        "A Y": "A X",
        "A Z": "A Y",
        "B X": "B X",
        "B Y": "B Y",
        "B Z": "B Z",
        "C X": "C Y",
        "C Y": "C Z",
        "C Z": "C X"
    }


if __name__ == '__main__':
    rps_pt1("input.txt")
    rps_pt2("input.txt")