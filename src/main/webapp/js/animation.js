function animateAndSubmit(form) {
  const taskContainer = form.closest('.task_item_container');
  if (!taskContainer) {
    console.log("No task item container found!");
    return;
  }

  console.log("Adding animation class to task container:", taskContainer.dataset.taskId);
  taskContainer.classList.add('fade-and-pink-animation');

  taskContainer.addEventListener('animationend', () => {
    console.log("Animation ended, submitting form for task:", taskContainer.dataset.taskId);
    form.submit();
  }, { once: true });
}


function setupCompleteButtonAnimations() {
  const deleteInputs = document.querySelectorAll('form input[name="_method"][value="DELETE"]');
  console.log(`Found ${deleteInputs.length} delete inputs`);

  deleteInputs.forEach(hiddenInput => {
    const form = hiddenInput.closest('form');
    if (!form) return;

    const button = form.querySelector('button[type="submit"]');
    if (!button) {
      console.log("No submit button found in form");
      return;
    }

    button.addEventListener('click', (e) => {
      e.preventDefault();
      animateAndSubmit(form);
    });
  });
}

document.addEventListener('DOMContentLoaded', () => {
  console.log("DOM loaded — setting up complete button animations");
  setupCompleteButtonAnimations();
});
