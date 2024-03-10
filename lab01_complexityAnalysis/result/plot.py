import matplotlib.pyplot as plt

bubble = [5, 10, 26, 53, 90, 137, 196, 267, 345, 432, 535, 644, 765, 899, 1043, 1194, 1363, 1547, 1738, 1916, 2120, 2342, 2572, 2808, 3073]
merge = [5, 5, 5, 6, 7, 8, 10, 10, 11, 10, 10, 11, 12, 9, 9, 9, 10, 10, 10, 11, 12, 12, 12, 12, 14]
selection = [5, 11, 10, 16, 17, 23, 31, 40, 51, 61, 76, 92, 107, 128, 146, 168, 188, 210, 237, 261, 291, 320, 356, 410, 501]
heap = [4, 5, 5, 7, 7, 5, 6, 6, 7, 7, 8, 9, 8, 10, 8, 8, 10, 10, 10, 10, 9, 10, 10, 11, 11]

x = [i for i in range(0,25000,1000)]


plt.figure(figsize=(10, 6))
# Plot the data
plt.plot(x, bubble, label='Bubble Sort')
plt.plot(x, merge, label='Merge Sort')
plt.plot(x, selection, label='Selection Sort')
plt.plot(x, heap, label='Heap Sort')


# Add title and labels
plt.title('Runtime of Repeated Integer List')
plt.xlabel('Data Scale')
plt.ylabel('Runtime (ms)')
plt.grid(True)
plt.legend()

# Show the plot
plt.show()
