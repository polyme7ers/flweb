import heapq

def dijkstra(graph, start):
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    priority_queue = [(0, start)]

    while priority_queue:
        current_distance, u = heapq.heappop(priority_queue)

        if current_distance > distances[u]:
            continue

        for v, weight in graph[u]:
            distance = current_distance + weight
            if distance < distances[v]:
                distances[v] = distance
                heapq.heappush(priority_queue, (distance, v))

    return distances

# Taking input from user
def main():
    graph = {}
    n = int(input("Enter number of nodes: "))
    e = int(input("Enter number of edges: "))

    for _ in range(e):
        u, v = input("Enter edge (u v ): ").split()
        print(u,v)
        w = int(input(f"Enter weight for edge {u}-{v}: "))
        if u not in graph:
            graph[u] = []
        if v not in graph:
            graph[v] = []
        graph[u].append((v, w))
        graph[v].append((u, w))  # If undirected graph

    start_node = input("Enter the start node: ")
    print(graph)
    distances = dijkstra(graph, start_node)
    print(f"\n{distances}")

    print("\nShortest distances from node", start_node)
   
    for node in sorted(distances.keys()):
        print(f"Node {node} : {distances[node]}")

if __name__ == "__main__":
    main()
