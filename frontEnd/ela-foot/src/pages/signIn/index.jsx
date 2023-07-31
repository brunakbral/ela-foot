import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import style from "./style.css";

export default function SignIn() {
  const [emailDigitado, setEmailDigitado] = useState("");
  const [senhaDigitada, setSenhaDigitada] = useState("");

  const login = "admin";
  const password = "admin";

  const navigate = useNavigate();

  function handleSubmit() {
    if (emailDigitado === login && senhaDigitada === password) {
      alert("Login efetuado com sucesso!");
      navigate("/home");
      //navigate to home

    } else {
      alert("Email ou senha incorretos!");
    }
  }

  return (
    <div id="background">
      <div className="mainSignIn" maxWidth="xs">
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            
          }}
        >
          <Typography component="h1" variant="h5">
            ELAFOOT
          </Typography>
          <Box
            component="form"
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 1 }}
          >
            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="Email "
              name="email"
              autoComplete="email"
              value={emailDigitado}
              onChange={(event) => setEmailDigitado(event.target.value)}
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Senha"
              type="password"
              id="password"
              value={senhaDigitada}
              onChange={(event) => setSenhaDigitada(event.target.value)}
              autoComplete="current-password"
            />
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Lembrar minha senha"
            />
            <Button id="signInButton"
              type="submit"
              fullWidth
              variant="contained"
              onClick={handleSubmit}
              sx={{ mt: 3, mb: 2 }}
            >Entrar
            </Button>
            <Grid container>
              <Grid item xs>
                <Link href="#" variant="body2">
                  Esqueceu sua senha?
                </Link>
              </Grid>
              <Grid item>
                <Link href="#" variant="body2">
                  {"Ainda não possui uma conta? Criar!"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </div>
    </div>
  );
}
