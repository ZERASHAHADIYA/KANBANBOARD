// Modal Functions
function openAddTaskModal() {
    document.getElementById('taskModal').classList.add('active');
    document.getElementById('modalTitle').textContent = 'Add New Task';
    document.getElementById('taskForm').reset();
    document.getElementById('taskId').value = '';
}

function closeTaskModal() {
    document.getElementById('taskModal').classList.remove('active');
}

function editTask(taskId) {
    // Fetch task details and populate form
    fetch('/api/tasks/' + taskId)
        .then(response => response.json())
        .then(task => {
            document.getElementById('taskModal').classList.add('active');
            document.getElementById('modalTitle').textContent = 'Edit Task';
            document.getElementById('taskId').value = task.taskId;
            document.getElementById('title').value = task.title;
            document.getElementById('description').value = task.description;
            document.getElementById('priority').value = task.priority;
            if (task.column) {
                document.getElementById('columnId').value = task.column.columnId;
            }
        })
        .catch(error => console.error('Error:', error));
}

function deleteTask(taskId) {
    if (confirm('Are you sure you want to delete this task?')) {
        fetch('/api/tasks/' + taskId, {
            method: 'DELETE'
        })
        .then(() => {
            location.reload();
        })
        .catch(error => console.error('Error:', error));
    }
}

// Close modal when clicking outside
window.onclick = function(event) {
    const modal = document.getElementById('taskModal');
    if (event.target === modal) {
        closeTaskModal();
    }
}

// Close modal on Escape key
document.addEventListener('keydown', function(event) {
    if (event.key === 'Escape') {
        closeTaskModal();
    }
});