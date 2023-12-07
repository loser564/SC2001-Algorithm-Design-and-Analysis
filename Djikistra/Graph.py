import subprocess
import time
import networkx as nx
import matplotlib.pyplot as plt
import numpy as np

# Define the range of the number of vertices
num_vertices_list = [10, 100, 200, 300, 400]  # Adjust as needed
num_trials = 100

# Initialize lists to store data for both algorithms
vertices = []
average_runtime_adj_list = []
average_runtime_matrix = []

for num_vertices in num_vertices_list:
    runtime_list_adj_list = []
    runtime_list_matrix = []
    
    for _ in range(num_trials):
        # Generate a random graph
        edge_probability = 0.1  # Dense graph, change this to get dense/sparse
        
        graph = nx.fast_gnp_random_graph(num_vertices, edge_probability)

        # Serialize the graph data to a string
        graph_data = '\n'.join(nx.generate_edgelist(graph, data=False))  # Convert the generator to a string

        # Compile and run the Java program using adjacency list implementation
        start_time = time.time()
        java_command = ["java", "-cp", ".", "DijkstraList"]  # Specify the classpath and class name
        process = subprocess.Popen(java_command, stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True, shell=False)
        stdout, _ = process.communicate(input=graph_data)
        end_time = time.time()
        runtime_list_adj_list.append(end_time - start_time)

        # Compile and run the Java program using matrix implementation
        start_time = time.time()
        java_command = ["java", "-cp", ".", "DijkstraMatrix"]  # Specify the classpath and class name
        process = subprocess.Popen(java_command, stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True, shell=False)
        stdout, _ = process.communicate(input=graph_data)
        end_time = time.time()
        runtime_list_matrix.append(end_time - start_time)

    # Calculate the average runtime for each representation
    average_runtime_adj_list.append(np.mean(runtime_list_adj_list))
    average_runtime_matrix.append(np.mean(runtime_list_matrix))

# Create a graph using Matplotlib to compare average runtimes
plt.figure(figsize=(8, 6))
plt.plot(num_vertices_list, average_runtime_adj_list, marker='o', linestyle='', label='Adjacency List')
plt.plot(num_vertices_list, average_runtime_matrix, marker='o', linestyle='', label='Matrix')
plt.xlabel('Number of Vertices')
plt.ylabel('Average Runtime (seconds)')
plt.title('Dijkstra Algorithm Runtime Comparison')
plt.legend()
plt.grid(True)

# Display the graph
plt.show()
