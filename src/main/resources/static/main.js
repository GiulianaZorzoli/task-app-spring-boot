const day = document.getElementById('day');
const month= document.getElementById('month');
const year = document.getElementById('year');

const today = new Date();

day.textContent=today.getDate();
year.textContent=today.getFullYear();

switch(today.getMonth()){
    case 0:
        month.textContent="January";
        break;
    case 1:
        month.textContent="February";
        break;
    case 2:
        month.textContent="March";
        break;
    case 3:
        month.textContent="April";
        break;
    case 4:
        month.textContent="May";
        break;
    case 5:
        month.textContent="June";
        break;
    case 6:
        month.textContent="July";
        break;
    case 7:
        month.textContent="August";
        break;
    case 8:
        month.textContent="September";
        break;
    case 9:
        month.textContent="October";
        break;
    case 10:
        month.textContent="November";
        break;
    case 11:
        month.textContent="December";
        break;
}