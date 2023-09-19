window.onload = function() {
    let button1 = document.getElementById('why')
    let button2 = document.getElementById('feature')
    let button3 = document.getElementById('resources')

    button1.onclick =  function() {
        button2.style.color = "white"
        button2.style.background = "rgb(32, 32, 31)"
        button3.style.color = "white"
        button3.style.background = "rgb(32, 32, 31)"
        this.style.background = "yellow";
        this.style.color = "black";
        let content = document.getElementById('content');
        content.innerHTML = '<ul><li>React is extremely popular</li><li>It makes building complex, interactive UIs a breeze</li><li>It\'s powerful & flexible</li><li>It has a very active and versatile ecosystem</li></ul>';
    };

    button2.onclick =  function() {
        button1.style.color = "white";
        button1.style.background = "rgb(32, 32, 31)"
        button3.style.color = "white"
        button3.style.background = "rgb(32, 32, 31)"
        this.style.background = "yellow";
        this.style.color = "black";
        let content = document.getElementById('content');
        content.innerHTML = '<ul><li>Core Features</li><li>Core Features</li><li>Core Features</li><li>Core Features</li></ul>';
    };

    button3.onclick =  function() {
        button1.style.color = "white"
        button1.style.background = "rgb(32, 32, 31)"
        button2.style.color = "white"
        button2.style.background = "rgb(32, 32, 31)"
        this.style.background = "yellow";
        this.style.color = "black";
        let content = document.getElementById('content');
        content.innerHTML = '<ul><li>Related Resources</li><li>Related Resources</li><li>Related Resources</li><li>Related Resources</li></ul>';
    };
};