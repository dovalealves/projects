// Project completed during week 11 of my 14 week Intensive Bootcamp at Academia de Codigo
//Promise.js used to practice and understand promises within JS


const url = "https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple";
let currentQuestionIndex = 0;
let triviaData = [];

$(document).ready(function () {

    async function logquiz() {
        try {
            const response = await fetch(url);
            const data = await response.json();
            triviaData = data.results;
            displayQuestion(currentQuestionIndex);
        } catch (error) {
            console.log(`An error occurred: ${error}`);
        }
    }

    function shuffle(array) {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
    }

    function displayQuestion(index) {
        const questionNumberElement = document.getElementById('question-number');
        questionNumberElement.textContent = `Question ${index + 1} of ${triviaData.length}`;

        const questionContainer = document.getElementById('question-container');
        const currentQuestion = triviaData[index];

        const options = [currentQuestion.correct_answer, ...currentQuestion.incorrect_answers];
        shuffle(options);

        document.getElementById('category').textContent = `Category: ${currentQuestion.category}`;
        document.getElementById('question').textContent = currentQuestion.question;

        const optionsContainer = document.getElementById('options');
        optionsContainer.innerHTML = '';

        options.forEach(option => {
            const optionElement = document.createElement('p');
            optionElement.textContent = option;
            optionElement.classList.add('option');
            optionElement.addEventListener('click', () => checkAnswer(option, currentQuestion.correct_answer));
            optionsContainer.appendChild(optionElement);
        });
    }

    function checkAnswer(selectedOption, correctAnswer) {
        if (selectedOption === correctAnswer) {
            alert("Correct!");
        } else {
            alert("Incorrect!");
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < triviaData.length) {
            displayQuestion(currentQuestionIndex);
        } else {
            alert("Quiz completed!");
        }
    }

    logquiz();

    const nextButton = document.getElementById('next-button');
    nextButton.addEventListener('click', () => {
        currentQuestionIndex++;
        if (currentQuestionIndex < triviaData.length) {
            displayQuestion(currentQuestionIndex);
        } else {
            alert("Quiz completed!");
        }
    });

});






