document.querySelectorAll('.info-row').forEach(row => {
  const editBtn = row.querySelector('.edit-btn');
  const saveBtn = row.querySelector('.save-btn');
  const span = row.querySelector('.value');
  const input = row.querySelector('.edit-input');

  editBtn.addEventListener('click', () => {
    input.value = span.textContent;
    span.style.display = 'none';
    input.style.display = 'inline-block';
    editBtn.style.display = 'none';
    saveBtn.style.display = 'inline-block';
  });

  saveBtn.addEventListener('click', () => {
    span.textContent = input.value;
    span.style.display = 'inline-block';
    input.style.display = 'none';
    editBtn.style.display = 'inline-block';
    saveBtn.style.display = 'none';
  });
});