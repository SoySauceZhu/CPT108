import matplotlib.pyplot as plt

bubble = [9, 8, 8, 7, 7, 7, 6, 7, 8, 7, 6, 6, 12, 10, 10, 8, 7, 7, 6, 7, 8, 7, 6, 7, 7, 6, 6, 7, 7, 7]
merge = [5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 6, 5, 6, 6, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7]
selection = [9, 10, 7, 7, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 8, 10, 7, 7, 8, 7, 7, 10, 7]
heap = [6, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 5, 4, 4, 4, 4, 5, 5]
x = [i for i in range(0,150,5)]


plt.figure(figsize=(10, 6))
# Plot the data
plt.plot(x, bubble, label='Bubble Sort')
plt.plot(x, merge, label='Merge Sort')
plt.plot(x, selection, label='Selection Sort')
plt.plot(x, heap, label='Heap Sort')


# Add title and labels
plt.title('Runtime of Ascending Integer List with pilot test')
plt.xlabel('Data Scale')
plt.ylabel('Runtime (ms)')
plt.grid(True)
plt.legend()

# Show the plot
plt.show()
