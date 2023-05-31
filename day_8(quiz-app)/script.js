var questions = [];

function addQuestion() {
  var question = document.getElementById("question").value;
  var option1 = document.getElementById("option1").value;
  var option2 = document.getElementById("option2").value;
  var option3 = document.getElementById("option3").value;
  var option4 = document.getElementById("option4").value;
  var answer = document.getElementById("answer").value;

  var newQuestion = {
    question: question,
    options: [option1, option2, option3, option4],
    answer: answer
  };

  questions.push(newQuestion);

  // Clear the input fields
  document.getElementById("question").value = "";
  document.getElementById("option1").value = "";
  document.getElementById("option2").value = "";
  document.getElementById("option3").value = "";
  document.getElementById("option4").value = "";
  document.getElementById("answer").value = "1";
}

function startQuiz() {
  var quizContainer = document.getElementById("quiz-container");
  quizContainer.innerHTML = "";

  for (var i = 0; i < questions.length; i++) {
    var question = questions[i];
    var questionDiv = document.createElement("div");
    var questionText = document.createElement("h3");
    questionText.innerHTML = question.question;
    questionDiv.appendChild(questionText);

    for (var j = 0; j < question.options.length; j++) {
      var option = document.createElement("input");
      option.type = "radio";
      option.name = "question" + i;
      option.value = j + 1;
      var optionLabel = document.createElement("label");
      optionLabel.innerHTML = question.options[j];
      questionDiv.appendChild(option);
      questionDiv.appendChild(optionLabel);
      questionDiv.appendChild(document.createElement("br"));
    }

    quizContainer.appendChild(questionDiv);
  }

  var submitButton = document.createElement("button");
  submitButton.innerHTML = "Submit";
  submitButton.onclick = submitQuiz;
  quizContainer.appendChild(submitButton);
}

function submitQuiz() {
  var score = 0;
  var quizContainer = document.getElementById("quiz-container");
  var questionDivs = quizContainer.getElementsByTagName("div");

  for (var i = 0; i < questionDivs.length; i++) {
    var questionDiv = questionDivs[i];
    var radios = questionDiv.getElementsByTagName("input");

    for (var j = 0; j < radios.length; j++) {
      var radio = radios[j];

      if (radio.checked) {
        var selectedAnswer = radio.value;

        if (selectedAnswer == questions[i].answer) {
          score++;
        }
      }
    }
  }

  alert("Quiz submitted! Your score: " + score);
  quizContainer.innerHTML = "";
}