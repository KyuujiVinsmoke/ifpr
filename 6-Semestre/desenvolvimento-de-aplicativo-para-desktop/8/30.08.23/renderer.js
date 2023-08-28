const axios = require('axios');

const getJokeButton = document.getElementById('getJokeButton');
const jokeText = document.getElementById('joke');
const catImage = document.getElementById('catImage');

getJokeButton.addEventListener('click', async () => {
  try {
    const jokeResponse = await axios.get('https://v2.jokeapi.dev/joke/Any?lang=pt');
    const jokeData = jokeResponse.data;

    if (jokeData.type === 'single') {
      jokeText.textContent = jokeData.joke;
    } else {
      jokeText.textContent = `${jokeData.setup} ${jokeData.delivery}`;
    }

    const catResponse = await axios.get('https://api.thecatapi.com/v1/images/search');
    const catImageUrl = catResponse.data[0].url;
    catImage.src = catImageUrl;
  } catch (error) {
    console.error(error);
  }
});