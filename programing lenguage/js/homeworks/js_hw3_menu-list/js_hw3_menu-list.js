const menu = [
  {
    id: 1,
    title: "Tteokbokki",
    category: "Korea",
    price: 10.99,
    img:
      "https://img.freepik.com/free-photo/korean-instant-noodle-tteokbokki-korean-spicy-sauce-ancient-food_1150-42999.jpg?size=626&ext=jpg&ga=GA1.1.68527928.1698616490&semt=sph",
    desc: `Spicy rice cakes, serving with fish cake.`,
  },
  {
    id: 2,
    title: "Chicken Ramen",
    category: "Japan",
    price: 7.99,
    img:
      "https://img.freepik.com/free-photo/delicious-ramen-dark-surface_1150-41973.jpg?size=626&ext=jpg&ga=GA1.1.68527928.1698616490&semt=ais",
    desc: `Chicken noodle soup, serving with vegetables such as soy bean, green onion. In an optional you can ask for egg. `,
  },
  {
    id: 3,
    title: "Bibimbap",
    category: "Korea",
    price: 8.99,
    img:
      "https://img.freepik.com/free-photo/assortment-korean-traditional-dishes-asian-food-top-view-flat-lay-generative-ai_1258-153045.jpg?q=10&h=200",
    desc: `Boiling vegetables, serving with special hot sauce`,
  },
  {
    id: 4,
    title: "Dan Dan Mian",
    category: "China",
    price: 5.99,
    img:
      "https://i2.wp.com/seonkyounglongest.com/wp-content/uploads/2019/10/Dan-Dan-Noodles-11.jpg?fit=2000%2C1333&ssl=1",
    desc: `Dan dan noodle, serving with green onion `,
  },
  {
    id: 5,
    title: "Yangzhou Fried Rice",
    category: "China",
    price: 12.99,
    img:
      "https://img.freepik.com/free-photo/hot-pepper-egg-cooking_1253-502.jpg?size=626&ext=jpg&ga=GA1.1.68527928.1698616490&semt=ais",
    desc: `Yangzhou style fried rice, serving with bean and pickles `,
  },
  {
    id: 6,
    title: "Onigiri",
    category: "Japan",
    price: 9.99,
    img:
      "https://img.freepik.com/free-photo/rice-ball-with-lettuce-seafood_23-2148259282.jpg?size=626&ext=jpg&ga=GA1.1.68527928.1698616490&semt=sph",
    desc: `Rice Sandwich, serving with soy sauce`,
  },
  {
    id: 7,
    title: "Jajangmyeon",
    category: "Korea",
    price: 15.99,
    img:
      "https://img.freepik.com/free-photo/korean-food-jajangmyeon-noodle-with-fermented-black-beans-sauce_1150-42835.jpg?size=626&ext=jpg&ga=GA1.1.68527928.1698616490&semt=sph",
    desc: `Black bean sauce noodle, serving with green onion `,
  },
  {
    id: 8,
    title: "Ma Yi Shang Shu",
    category: "China",
    price: 12.99,
    img:
      "https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/F688C2F6-86EC-46C4-B9C7-A6BA01DF7437/Derivates/32E3E72A-F786-406D-AF7F-B30980A9AC6C.jpg",
    desc: `Hot pepper sauce noodle, serving with soy bean and onion`,
  },
  {
    id: 9,
    title: "Doroyaki",
    category: "Japan",
    price: 3.99,
    img:
      "https://img.freepik.com/free-photo/man-holding-sticks-with-tempura-roll-rice-crab-cream-cheese-sesame-eel-ginger-wasabi-side-view_141793-3566.jpg?size=626&ext=jpg&ga=GA1.1.68527928.1698616490&semt=ais",
    desc: `Red bean paste dessert, serving with honey.`,
  },
  {
    id: 10,
    title: "Kaeng Khiao Wan Ka",
    category: "Thailand",
    price: 7.99,
    img:
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyJRrsNVHU9KlcL6ATqruR46L5Qakqv6MZxNdc9tb8C4vrhw_SY9t2ndKKfcqBpz2JDGY&usqp=CAU",
    desc: `Chicken breast, green Thai curry cake, bamboo shoot, green pepper, coconut milk and fresh coriander..`,
  },
  {
    id: 11,
    title: "Phat Kaphrao",
    category: "Thailand",
    price: 9.99,
    img:
      "https://i.ytimg.com/vi/DOTImW7hH0E/maxresdefault.jpg",
    desc: `Traditional Thai dish prepared with minced meat (duck, chicken or beef), fresh peppers, fresh basil leaves and spices.`,
  },
  {
    id: 12,
    title: "Alinazik",
    category: "Turkish",
    price: 5.99,
    img:
      "https://i.nefisyemektarifleri.com/2021/02/20/ali-nazik-kiymali-11.jpg",
    desc: `Traditional Turkish dish flavored with grilled eggplant puree and beef with yoghurt`,
  },
  {
    id: 13,
    title: "Kokoreç",
    category: "Turkish",
    price: 13.99,
    img:
      "https://images.deliveryhero.io/image/fd-tr/LH/f79b-hero.jpg",
    desc: `A delicious street food prepared by blending thinly cut beef or lamb intestines with spices and fresh herbs.`,
  }
];
 
document.addEventListener("DOMContentLoaded",function(){
  let button_DOM = document.getElementById("buttonGroup")
  let list_DOM = document.getElementById("locationList")

  function fiilingList (index) {
    return `
      <div class="col-md-4 offset-md-1 mt-2 mb-2">            
        <div class="card" style="width: 100%;">
          <img src="${index.img}" class="card-img-start" 
          alt="..."
          style="
            max-height: 300px;
            max-height: 200px;   
          ">
          <div class="card-body" style="height:100px">
            <h5 class="card-title">
              ${index.title}
            </h5>
            <p class="card-text">
              Content  ${index.desc}
            </p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              Catogorry : ${index.category}
            </li>
            <li class="list-group-item">
              Prize : ${index.price} 
            </li>
          </ul>
        </div>
      </div>
    `
  }

  function print (filteredCategory ){
    list_DOM.innerHTML = ""
    if(filteredCategory  === "all"){
      menu.forEach(filteredCategory  => {
        list_DOM.innerHTML += fiilingList(filteredCategory )
      });
    }
    else {
      let filteredMenu = menu.filter(item => item.category  === filteredCategory )
      console.log(filteredMenu)
      filteredMenu.forEach(item => {
        list_DOM.innerHTML += fiilingList(item)
      })
    }
  }

  button_DOM.addEventListener("click",function(e){
    e.preventDefault()
    if (e.target.tagName === "BUTTON"){

      const selectedCategory = e.target.id

      if(selectedCategory === "all"){
        console.log("pressed all buton")
        print("all")
      }
      else if (selectedCategory === "China"){
        console.log("pressed china buton")
        print("China")
      }
      else if (selectedCategory === "Japan"){
        console.log("pressed japan buton")
        print("Japan")
      }
      else if (selectedCategory === "Korea"){
        console.log("pressed Korea buton")
        print("Korea")
      }
      else if (selectedCategory === "Thailand"){
        print("Thailand")
      }
      else if (selectedCategory === "Turkish"){
        console.log("pressed turkish buton")
        print("Turkish")
      }
      else{
        alert("I don't know how you did it, but good luck to you. ")
      }
    }
  })
})
