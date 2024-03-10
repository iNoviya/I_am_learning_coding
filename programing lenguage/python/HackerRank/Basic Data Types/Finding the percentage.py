if __name__ == '__main__':
    n = int(input())
    student_marks = {}
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    query_name = input()
    total=0
    for i in range(len(student_marks[query_name])):
        total+=student_marks[query_name][i]
    average = float(total / (len(student_marks[query_name])))
    
    print(f"{average:.2f}")