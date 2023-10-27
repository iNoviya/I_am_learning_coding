let form_DOM = document.getElementById("form")
let input_DOM = document.getElementById("inputArea")
let list_DOM = document.getElementById("list")

document.addEventListener("DOMContentLoaded",function(){
    let tasks = JSON.parse(localStorage.getItem("tasks")) || []


    function addList (){
        list_DOM.innerHTML = ""
        tasks.forEach(function(task,index){
            const li = document.createElement('li')
            li.classList.add("list-group-item",
                "list-group-item-action",
                "d-flex",
                "justify-content-between",
                "align-items-center")
            li.innerHTML =`
            <input 
                class="
                    form-check-input 
                    me-1
                " 
                type="checkbox"  
                id="task${index}"
                ${task.complated ? "checked" : ""}
                >
            <label 
                class="
                    form-check-label
                    flex-grow-1
                    ${task.complated ? "completed" : ""}
                " 
                for="task${index}"
            >
                ${task.text}
            </label>
            <button
               class="
                  btn 
                  btn-danger 
                  btn-sm 
                  delete-btn
               "
               type=" button"
            >
               delete
            </button>
            `
            list_DOM.append(li)
        })
    }


    form_DOM.addEventListener("submit",function(e){
        e.preventDefault()
        console.log("press submit button",input_DOM)
        const text = input_DOM.value.trim()

        if (text !== "") {
            const newTask = {
                text,
                complated:false
            }
            tasks.push(newTask)
            localStorage.setItem("tasks",JSON.stringify(tasks))
            input_DOM.value = ""
            addList()
        }
        else {
            alert("error!!!  check again")
        }
    })

    list_DOM.addEventListener("change",function(e){
        if (e.target.type === "checkbox"){
            const index = e.target.id.replace("task", "")
            tasks[index].complated= e.target.checked
            localStorage.setItem("tasks",JSON.stringify(tasks))
            addList()
        }
    })

    list_DOM.addEventListener("click",function(e){
        if(e.target.classList.contains("delete-btn")){
            const index = e.target.parentElement.querySelector("input[type='checkbox']").id.replace("task","")
            tasks.splice(index,1)
            localStorage.setItem("tasks",JSON.stringify(tasks))
            addList()
        }
    })

    addList()
})

