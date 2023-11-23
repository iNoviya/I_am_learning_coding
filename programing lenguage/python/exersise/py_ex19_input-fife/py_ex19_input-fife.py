sudokuFile = []

with open('sudoku.txt', 'r+') as file:
    for i in file:
        event_row = i.split()
        for eleman in event_row:
            sudokuFile.append(int(eleman)) 

sudoku = [ # this is just a tamblete to use it
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0]
]

for i in range(len(sudokuFile)):
    r = i //9
    c = i %9
    sudoku[r][c] = sudokuFile[i]

sudokulist = []
sudoku_cikti = ""
for row in sudoku:
    for e in row:
        sudokulist.append(e)

for i, eleman in enumerate(sudokulist, start=1):
    if i % 9 == 0:
        print(eleman,"")
        sudoku_cikti += str(eleman) + "\n"
    else:
        print(eleman, end=" ")  # Her eleman arasında boşluk olmadan
        sudoku_cikti += str(eleman)+" "

# Elde edilen çıktıyı görüntüleme
print(sudoku_cikti)