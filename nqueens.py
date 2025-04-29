# Python program to solve N Queen Problem using backtracking

# def printSolution(board, N):
#     for i in range(N):
#         for j in range(N):
#             print(board[i][j], end=' ')
#         print()

# def isSafe(board, row, col, N):
#     for i in range(col):
#         if board[row][i] == 1:
#             return False

#     for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
#         if board[i][j] == 1:
#             return False

#     for i, j in zip(range(row, N, 1), range(col, -1, -1)):
#         if board[i][j] == 1:
#             return False

#     return True

# def solveNQUtil(board, col, N):
#     if col >= N:
#         return True

#     for i in range(N):
#         if isSafe(board, i, col, N):
#             board[i][col] = 1
#             if solveNQUtil(board, col + 1, N):
#                 return True
#             board[i][col] = 0  # Backtrack

#     return False

# def solveNQ(N):
#     board = [[0 for _ in range(N)] for _ in range(N)]
#     if not solveNQUtil(board, 0, N):
#         print("Solution does not exist")
#         return False
#     printSolution(board, N)
#     return True

# # Driver code
# # if __name__ == "__main__":


# N = int(input("Enter the number of Queens (N): "))
# solveNQ(N)




def printboard(board,N):
    for i in range(N):
        for j in range(N):
            print('Q' if board[i][j]==1 else '.',end=' ')
        print()
    print()

def isSafe(board,row,col,N):
    for i in range(col):
        if board[row][i]==1:
            return False
    for i,j in zip(range(row,-1,-1),range(col,-1,-1)):
        if board[i][j]==1:
            return False
    for i,j in zip(range(row,N,1),range(col,-1,-1)):
        if board[i][j]==1:
            return False
    return True

def  SolvenQutil(board,col,N):
    if col>=N:
        printboard(board,N)
        return True
    for i in range(N):
        if isSafe(board,i,col,N):
            board[i][col]=1
            SolvenQutil(board,col+1,N)
            board[i][col]=0
    

def SolvenQ(N):
    board=[[0 for _ in range(N)]for _ in range(N)]
    SolvenQutil(board,0,N)
       

N=int(input("Enter the number of Queens (N): "))       
SolvenQ(N)