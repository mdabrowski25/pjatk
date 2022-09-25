let form = document.getElementById('addToNewsletter');
let table = document.getElementById('newsletter-table-content');



form.addEventListener('submit', function (ev) {
    ev.preventDefault();
    let firstname = document.getElementById('name').value;
    let lastname = document.getElementById('lastname').value;
    let age = document.getElementById('age').value;
    let shoeNumber = document.getElementById('shoe-number').value;

    const tableRowElement = document.createElement('tr');
    const tableDataCellElement1 = document.createElement('td');
    tableDataCellElement1.textContent = firstname;
    const tableDataCellElement2 = document.createElement('td');
    tableDataCellElement2.textContent = lastname;
    const tableDataCellElement3 = document.createElement('td');
    tableDataCellElement3.textContent = age;
    const tableDataCellElement4 = document.createElement('td');
    tableDataCellElement4.textContent = shoeNumber;

    tableRowElement.appendChild(tableDataCellElement1);
    tableRowElement.appendChild(tableDataCellElement2);
    tableRowElement.appendChild(tableDataCellElement3);
    tableRowElement.appendChild(tableDataCellElement4);

    table.appendChild(tableRowElement);
});
