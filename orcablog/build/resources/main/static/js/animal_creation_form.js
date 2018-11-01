    $(document).ready(function(){

        let singleAnimalRegex = /0123456789/;

           if(window.location.pathname == "/animals/create" || window.location.href.indexOf("/animals/edit") > -1){

                var text_max = 255;
                $('#count_message').html(text_max + ' remaining');

                $('#text').keyup(function() {
                var text_length = $('#text').val().length;
                var text_remaining = text_max - text_length;

                $('#count_message').html(text_remaining + ' remaining');
                });

               var strengthSlider = document.getElementById("strengthRange");
               var dexteritySlider = document.getElementById("dexterityRange");
               var defenseSlider = document.getElementById("defenseRange");
               var speedSlider = document.getElementById("speedRange");

               var strengthOutput = document.getElementById("strengthOut");
               var dexterityOutput = document.getElementById("dexterityOut");
               var defenseOutput = document.getElementById("defenseOut");
               var speedOutput = document.getElementById("speedOut");

               strengthOutput.innerHTML = strengthSlider.value;
               dexterityOutput.innerHTML = dexteritySlider.value;
               defenseOutput.innerHTML = defenseSlider.value;
               speedOutput.innerHTML = speedSlider.value;

               strengthSlider.oninput = function() {
                 strengthOutput.innerHTML = this.value;
               }
               dexteritySlider.oninput = function() {
                 dexterityOutput.innerHTML = this.value;
               }
               defenseSlider.oninput = function() {
                 defenseOutput.innerHTML = this.value;
               }
               speedSlider.oninput = function() {
                 speedOutput.innerHTML = this.value;
               }
           }
    });