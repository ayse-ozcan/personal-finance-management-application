import { ThemeProvider } from "@emotion/react";
import {
  Avatar,
  Box,
  Button,
  Container,
  Grid,
  Paper,
  TextField,
  createTheme,
} from "@mui/material";
import React, { useState } from "react";
import Header from "../../components/Header";
import KeyIcon from "@mui/icons-material/Key";
import Footer from "../../components/Footer";
import { getUserTokenFromStorage } from "../../store/user-store";
import img2 from "../../assets/img/profile.jpg";
import axios from "axios";

const defaultTheme = createTheme();

const ChangePassword = () => {
  const [userData, setUserData] = useState({
    newPassword: "",
  });

  const token = getUserTokenFromStorage();

  const handleSave = () => {
    const passwordDto = {
      token: token,
      newPassword: userData.newPassword,
    };

    axios
      .put("http://localhost:9090/api/v1/user/change-password", passwordDto)
      .then((response) => {
        alert("Password changed successfully!");
      })
      .catch((error) => {
        alert("Something went wrong!");
      });
  };

  const backgroundImg2 = img2;

  return (
    <ThemeProvider theme={defaultTheme}>
      <Header />
      <Container>
        <Grid
          container
          justifyContent="center"
          alignItems="center"
          className="profile"
          style={{
            minHeight: "100vh",
            marginTop: "1%",
          }}
        >
          <Paper
            elevation={3}
            style={{
              padding: 100,
              background: "#f0f0f0",
              marginTop: "1%",
              backgroundColor: "#f0f0f0",
              backgroundImage: `url(${backgroundImg2})`,
              backgroundSize: "cover",
              backgroundRepeat: "no-repeat",
              backgroundPosition: "center",
            }}
          >
            <Avatar
              sx={{ bgcolor: "#1976d2", marginLeft: 12, marginBottom: 2 }}
            >
              <KeyIcon />
            </Avatar>
            <p
              style={{
                marginBottom: "0",
                marginLeft: "23%",
                fontWeight: "bold",
              }}
            >
              {" "}
              Change Password
            </p>
            <Box p={2}>
              <TextField
                label="Password"
                fullWidth
                value={userData.newPassword}
                onChange={(e) =>
                  setUserData({ ...userData, newPassword: e.target.value })
                }
              />
            </Box>
            <Box p={2}>
              <Button
                sx={{
                  marginLeft: "33%",
                  color: "black",
                  fontFamily: "bold",
                  border: "2px solid black",
                  borderRadius: "4px",
                }}
                onClick={handleSave}
              >
                Save
              </Button>
            </Box>
          </Paper>
        </Grid>
        <Footer />
      </Container>
    </ThemeProvider>
  );
};

export default ChangePassword;
