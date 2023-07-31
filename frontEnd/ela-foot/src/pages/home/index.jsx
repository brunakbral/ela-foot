import React from "react";
import { useState } from "react";
import style from "./style.css";
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";
import Button from "@mui/material/Button";

export default function Home() {
  const [selectedPlayer, setSelectedPlayer] = useState();

  const players = [
    { name: "Marta", posição: "Atacante", idade: 35, altura: 1.62, peso: 60 },
    { name: "Debinha", posição: "Atacante", idade: 29, altura: 1.6, peso: 60 },
    { name: "Formiga", posição: "Meio-campo", idade: 43, altura: 1.6, peso: 60 },
    { name: "Bárbara", posição: "Goleira", idade: 33, altura: 1.75, peso: 70 },
  ];

  const playerAtributes = [
    { name: "Ofensivo", value: 20 },
    { name: "Defensivo", value: 30 },
    { name: "Passe", value: 40 },
    { name: "Drible", value: 50 },
    { name: "Posicionamento", value: 60 },
    { name: "Habilidade", value: 70 },
    { name: "Equipe", value: 80 },
    { name: "Concentração", value: 90 },
    { name: "Liderança", value: 100 },
    { name: "Bravura", value: 100 },
    { name: "Postura", value: 100 },
    { name: "Decisões", value: 100 },
    { name: "Força", value: 100 },
    { name: "Reflexo", value: 100 },
    { name: "Pulo", value: 100 },
    { name: "Cardio", value: 100 },
    { name: "Equilíbrio", value: 100 },
    { name: "Aceleração", value: 100 },
  ];

  function imprimirTecnicas() {
    return playerAtributes.map((playerAtribute, index) => {
      if (index < 6) {
        return (
          <>
            <div className="atribute">
              <h2>{playerAtribute.name}</h2>
              <TextField
                id="outlined-number"
                type="number"
                value={playerAtribute.value}
                sx={{ width: 70 }}
                InputLabelProps={{
                  shrink: true,
                }}
              />
            </div>
          </>
        );
      }
    });
  }
  function imprimirMentais() {
    return playerAtributes.map((playerAtribute, index) => {
      if (index >= 6 && index < 12) {
        return (
          <>
            <div className="atribute">
              <h2>{playerAtribute.name}</h2>
              <TextField
                id="outlined-number"
                type="number"
                value={playerAtribute.value}
                sx={{ width: 70 }}
                InputLabelProps={{
                  shrink: true,
                }}
              />
            </div>
          </>
        );
      }
    });
  }
  function imprimirFisicas() {
    return playerAtributes.map((playerAtribute, index) => {
      if (index >= 12) {
        return (
          <>
            <div className="atribute">
              <h2>{playerAtribute.name}</h2>
              <TextField
                id="outlined-number"
                type="number"
                value={playerAtribute.value}
                sx={{ width: 70 }}
                InputLabelProps={{
                  shrink: true,
                }}
              />
            </div>
          </>
        );
      }
    });
  }

  return (
    <div id="background">
      <main id="main">
        <p class="welcome">Olá, Usuário!</p>
        <div class="playerData">
          <div class="playerAtributes1">
            <Autocomplete
              onChange={(event, newValue) => {
                setSelectedPlayer(newValue);
              }}
              disablePortal
              id="combo-box"
              options={players}
              getOptionLabel={(option) => option.name}
              size="small"
              sx={{ width: 280 }}
              renderInput={(params) => (
                <TextField
                  variant="filled"
                  {...params}
                  label="Escolher uma jogadora"
                  InputProps={{
                    ...params.InputProps,
                    sx: {
                      bgcolor: "rgb(211, 211,131)",
                      borderColor: "#4B783F",
                      color: "rgb(73, 70, 70)",
                      "&:hover": {
                        borderColor: "#4B783F",
                        color: "rgb(73, 70, 70)",
                      },
                      "&.Mui-focused": {
                        borderColor: "#4B783F",
                        bgcolor: "rgb(211, 211,131)",
                        color: "rgb(73, 70, 70)",
                      },
                    },
                  }}
                />
              )}
            />
            <div class="playerCard">
              <h1>Marta</h1>
              <div class="photo"></div>
              <h2>Atacante</h2>
              <h3>Idade</h3>
              <h3>Peso</h3>
              <h3>Altura</h3>
            </div>
              <Button className="styledButton" variant="contained" color="success" onClick={console.log(selectedPlayer)}>
                Cadastrar nova jogadora
              </Button>
          </div>
          <div class="playerAtributes2">
            <h1>Habilidades</h1>
            <div className="playerSkills">
              <div className="skill">
                <h2 className="cabecalho">Técnicas</h2>
                <div className="skills">
                    {imprimirTecnicas()}
                </div>
              </div>
              <div className="skill">
                <h2 className="cabecalho">Mentais</h2>
                <div className="skills">
                    {imprimirMentais()}
                </div>
              </div>
              <div className="skill">
                <h2 className="cabecalho">Físicas</h2>
                <div className="skills">
                    {imprimirFisicas()}
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}
