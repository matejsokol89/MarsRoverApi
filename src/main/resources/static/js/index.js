    let marsApiButtons = document.querySelectorAll("button[id*='marsApi']")
    marsApiButtons.forEach( button => button.addEventListener('click', function () {
    									const buttonId = this.id
    									const roverId = buttonId.split('marsApi')[1]
    									let apiData = document.getElementById('marsApiRoverData')
    									apiData.value = roverId
    									document.getElementById('frmRoverType').submit()
    								  }))

    let urlParams = new URLSearchParams(window.location.search);
    let roverType = urlParams.get("marsApiRoverData")
    let marsSol = urlParams.get("marsSol")
    if (marsSol == null){
    marsSol = 1
    }
    document.getElementById("marsSol").value = marsSol

    for (let i = 0;i<marsApiButtons.length;i++){
        if (roverType == null){
            roverType = 'Opportunity'

        }
        if (marsApiButtons[i].innerHTML.toLowerCase() == roverType.toLowerCase()){
            marsApiButtons[i].classList.remove("btn-secondary");
            marsApiButtons[i].classList.add("btn-primary");
        } else{
            marsApiButtons[i].classList.add("btn-secondary");
            marsApiButtons[i].classList.remove("btn-primary");
        }
    }