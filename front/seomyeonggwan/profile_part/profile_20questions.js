window.onload = function() {
    const menuButtons = document.querySelectorAll('.menu_button');

    menuButtons.forEach(button => {
        button.addEventListener('click', () => {
            menuButtons.forEach(btn => {
                btn.classList.remove('active');
            });

            button.classList.add('active');
        });
    });
}