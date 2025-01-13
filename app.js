const app = Vue.createApp({
    data() {
        return {
            pokemonA: '', // User input for Pokémon A
            pokemonB: '', // User input for Pokémon B
            result: null // Result of the battle
        };
    },
    methods: {
        battle() {
            if (!this.pokemonA || !this.pokemonB) {
                alert('Please enter both Pokémon names!');
                return;
            }

            fetch(`/attack?pokemonA=${this.pokemonA}&pokemonB=${this.pokemonB}`)
                .then(response => response.json())
                .then(data => {
                    if (data.error) {
                        alert(data.error);
                        this.result = null;
                    } else {
                        this.result = data; // Set the result object
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Something went wrong. Please try again!');
                });
        }
    }
});

app.mount('#app');
