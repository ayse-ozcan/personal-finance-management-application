import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import {
  Avatar,
  Card,
  Container,
  Grid,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  ThemeProvider,
  createTheme,
} from "@mui/material";
import Header from "../../components/Header";
import AssignmentIndIcon from "@mui/icons-material/AssignmentInd";
import Footer from "../../components/Footer";

const defaultTheme = createTheme();

const Profile = () => {
  return (
    <ThemeProvider theme={defaultTheme}>
      <Header />
      <Container>
        <Grid
          container
          justifyContent="center"
          alignItems="center"
          style={{ minHeight: "100vh" }}
        >
          <Paper
            elevation={3}
            style={{ padding: 170, background: "#f0f0f0", marginTop: "2%" }}
          >
            <Avatar sx={{ m: 1, bgcolor: "#1976d2" }}>
              <AssignmentIndIcon />{" "}
            </Avatar>
            <Box p={2}>
              <TextField label="Username" fullWidth />
            </Box>
            <Box p={2}>
              <TextField label="Name" fullWidth />
            </Box>
            <Box p={2}>
              <TextField label="Surname" fullWidth />
            </Box>
            <Box p={2}>
              <TextField label="Email" fullWidth />
            </Box>
          </Paper>
        </Grid>
        <Footer />
      </Container>
    </ThemeProvider>
  );
};

export default Profile;
