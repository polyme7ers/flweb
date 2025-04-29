from collections import deque

def recursive_bfs(queue, visited, graph):
    if not queue:
        return
    node = queue.popleft()
    print(node, end=" ")

    for neighbor in graph.get(node, []):
        if neighbor not in visited:
            visited.add(neighbor)
            queue.append(neighbor)
    recursive_bfs(queue, visited, graph)

def recursive_dfs(visited, graph, node):
    if node not in visited:
        print(node, end=" ")
        visited.add(node)
        for neighbor in graph.get(node, []):
            recursive_dfs(visited, graph, neighbor)

# --- Taking input from the user ---
graph = {}
n = int(input("Enter number of nodes in the graph: "))

for _ in range(n):
    node = input(f"Enter node name: ").strip()
    neighbors = input(f"Enter neighbors of {node} separated by space: ").strip().split()
    graph[node] = neighbors

print("\nGraph is:", graph)

# --- Taking starting node ---
start_node = input("\nEnter the starting node: ").strip()

# --- DFS ---
print("\nRecursive DFS traversal:")
visited_dfs = set()
recursive_dfs(visited_dfs, graph, start_node)

# --- BFS ---
print("\n\nRecursive BFS traversal:")
visited_bfs = set()
queue = deque()
queue.append(start_node)
visited_bfs.add(start_node)
recursive_bfs(queue, visited_bfs, graph)