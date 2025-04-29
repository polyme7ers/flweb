import heapq

def prim_mst(graph, start):
    mst = []
    visited = set()
    min_heap = [(0, start, -1)]  # (cost, current_node, parent)

    while min_heap:
        cost, u, parent = heapq.heappop(min_heap)
        if u in visited:
            continue
        visited.add(u)
        if parent != -1:
            mst.append((parent, u, cost))

        for v, weight in graph[u]:
            if v not in visited:
                heapq.heappush(min_heap, (weight, v, u))

    return mst

def get_input():
    num_nodes = int(input("Enter the number of nodes: "))
    graph = {}

    # Get the edges and their weights from the user
    num_edges = int(input("Enter the number of edges: "))
    print("Enter each edge in the format 'u v weight':")
    for _ in range(num_edges):
        u, v=input("Enter the edge(u v):").split()
        w=int(input(f"Enter the weight for edge {u}-{v}:"))
        if u not in graph:
            graph[u]=[]
        if v not in graph:
            graph[v]=[]
        graph[u].append((v, w))
        graph[v].append((u, w))  # Since it's an undirected graph

    # Get the start node
    start_node = input("Enter the start node: ")
    print("Graph:", graph)
    
    
    mst = prim_mst(graph, start_node)

    print("Edges in MST:")
    for u, v, weight in mst:
        print(f"{u} - {v} (weight {weight})")

# Example Usage

    
get_input()