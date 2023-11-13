import { ThemeProvider } from "@emotion/react";
import React, { useState } from "react";
import Header from "../../components/Header";
import {
  Container,
  Grid,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  TextField,
  Select,
  MenuItem,
  createTheme,
  Button,
} from "@mui/material";
import Footer from "../../components/Footer";
import img from "../../assets/img/profile.jpg";
import DeleteOutlineIcon from "@mui/icons-material/DeleteOutline";
import EditNoteIcon from "@mui/icons-material/EditNote";
const defaultTheme = createTheme();

const HomePage = () => {
  const backgroundImg = img;
  const [incomeCategory, setIncomeCategory] = useState("");
  const [expenseCategory, setExpenseCategory] = useState("");

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
            backgroundImage: `url(${backgroundImg})`,
            backgroundSize: "cover",
            backgroundRepeat: "no-repeat",
            backgroundPosition: "center",
          }}
        >
          <Paper
            elevation={3}
            style={{
              padding: 100,
              minWidth: "70%",
              background: "#f0f0f0",
              marginTop: "1%",
              backgroundColor: "#f0f0f0",
            }}
          >
            <TableContainer component={Paper}>
              <Table
                sx={{ minWidth: 650 }}
                size="small"
                aria-label="a dense table"
              >
                <TableHead>
                  <TableRow>
                    <TableCell>
                      <b>INCOME</b>
                    </TableCell>
                    <TableCell>Description</TableCell>
                    <TableCell>Category</TableCell>
                    <TableCell>Price</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  <TableRow>
                    <TableCell
                      align="left"
                      component="th"
                      scope="row"
                    ></TableCell>
                    <TableCell>
                      <TextField
                        style={{ fontSize: "small", padding: "0.5rem" }}
                      />
                    </TableCell>
                    <TableCell align="left">
                      <Select
                        value={incomeCategory}
                        onChange={(e) => setIncomeCategory(e.target.value)}
                        style={{ fontSize: "small", padding: "0.5rem" }}
                      >
                        <MenuItem value="Salary">Salary</MenuItem>
                        <MenuItem value="Exchange">Exchange</MenuItem>
                      </Select>
                    </TableCell>
                    <TableCell>
                      <TextField
                        style={{
                          fontSize: "small",
                          paddingLeft: "0.5rem",
                          paddingTop: "0.5rem",
                        }}
                      />
                    </TableCell>
                    <Button>
                      <EditNoteIcon />
                    </Button>
                    <Button>
                      <DeleteOutlineIcon />
                    </Button>
                  </TableRow>
                </TableBody>
              </Table>
            </TableContainer>
            <br />
            <br />
            <TableContainer component={Paper}>
              <Table
                sx={{ minWidth: 900 }}
                size="medium"
                aria-label="a dense table"
              >
                <TableHead>
                  <TableRow>
                    <TableCell>
                      <b>EXPENSE</b>
                    </TableCell>
                    <TableCell>Description</TableCell>
                    <TableCell>Category</TableCell>
                    <TableCell>Price</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  <TableRow>
                    <TableCell component="th" scope="row"></TableCell>
                    <TableCell align="left">
                      <TextField
                        style={{
                          fontSize: "small",
                          padding: "0.5rem",
                        }}
                      />
                    </TableCell>
                    <TableCell align="left">
                      <Select
                        value={expenseCategory}
                        onChange={(e) => setExpenseCategory(e.target.value)}
                        style={{
                          fontSize: "small",
                          padding: "0.5rem",
                        }}
                      >
                        <MenuItem
                          style={{ minWidth: "150px" }}
                          value="Groceries"
                        >
                          Groceries
                        </MenuItem>
                        <MenuItem style={{ minWidth: "150px" }} value="Rent">
                          Rent
                        </MenuItem>
                      </Select>
                    </TableCell>
                    <TableCell align="left">
                      <TextField
                        style={{
                          type: "number",
                          fontSize: "small",
                          paddingLeft: "0.5rem",
                          paddingTop: "0.5rem",
                        }}
                      />
                      <Button>
                        <EditNoteIcon />
                      </Button>
                      <Button>
                        <DeleteOutlineIcon />
                      </Button>
                    </TableCell>
                  </TableRow>
                </TableBody>
              </Table>
            </TableContainer>
          </Paper>
        </Grid>
        <Footer />
      </Container>
    </ThemeProvider>
  );
};

export default HomePage;
