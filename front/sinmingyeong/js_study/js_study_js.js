const tabMenus = document.querySelectorAll('.tab-menu li');
const tabContents = document.querySelectorAll('.tab-content section');


const activeSection = (e) => {
    e.stopPropagation();

    let menuIndex = [...tabMenus].indexOf(e.target);

    tabMenus.forEach(menu => {
        [...tabMenus].indexOf(menu) === menuIndex
            ? menu.classList.add('active')
            : menu.classList.remove('active')
    });

    tabContents.forEach(content => {
        [...tabContents].indexOf(content) === menuIndex
            ? content.classList.add('active')
            : content.classList.remove('active')
    });
}


[...tabMenus][0].classList.add('active');
[...tabContents][0].classList.add('active');

tabMenus.forEach(menu => {
    menu.addEventListener('click', activeSection)
})
