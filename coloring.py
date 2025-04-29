# Number of vertices in the graph
V = 4

def printSolution(color):
    """Print the coloring solution"""
    print("Vertex coloring solution:")
    for i in range(V):
        print(f"Vertex {i} → Color {color[i]}")
    print()

def isSafe(graph, v, color, c):
    """
    Check if color c can be assigned to vertex v
    Similar to isSafe in N-Queens, but checks adjacent vertices instead of diagonals
    """
    for i in range(V):
        if graph[v][i] == 1 and color[i] == c:
            return False
    return True

def graphColoringUtil(graph, m, color, v):
    """
    Recursive utility function to solve graph coloring
    Similar to solveNQUtil in N-Queens
    """
    # Base case: All vertices are colored
    if v == V:
        return True
    
    # Try all colors for current vertex v
    for c in range(1, m + 1):
        if isSafe(graph, v, color, c):
            color[v] = c
            
            # Recur to color next vertices
            if graphColoringUtil(graph, m, color, v + 1):
                return True
                
            # Backtrack if coloring doesn't lead to solution
            color[v] = 0
    
    return False

def graphColoring():
    """
    Main function to solve graph coloring problem
    Similar to solveNQ in N-Queens
    """
    # Initialize color array (0 means uncolored)
    graph = [
        [0, 1, 1, 1],
        [1, 0, 1, 0],
        [1, 1, 0, 1],
        [1, 0, 1, 0]
    ]
    
    # Number of colors
    m = 3
    color = [0] * V
    
    if not graphColoringUtil(graph, m, color, 0):
        print("No solution exists with", m, "colors")
        return False
    
    printSolution(color)
    return True

graphColoring()