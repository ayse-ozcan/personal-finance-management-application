import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import SavingsIcon from "@mui/icons-material/Savings";
import ExitToAppIcon from "@mui/icons-material/ExitToApp";
import HomeIcon from "@mui/icons-material/Home";
import HowToRegIcon from "@mui/icons-material/HowToReg";
import SettingsSuggestIcon from "@mui/icons-material/SettingsSuggest";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { removeUserTokenFromStorage } from "../store/user-store";

function Header() {
  const navigate = useNavigate();
  const onClickSignOut = () => {
    navigate("/sign-in");
    removeUserTokenFromStorage();
  };
  const handleNavigation = (path) => {
    navigate(path);
  };

  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <SavingsIcon
            sx={{
              display: { xs: "none", md: "flex" },
              mr: 2,
              fontSize: "250%",
            }}
          />
          <Typography
            variant="h5"
            noWrap
            component="a"
            sx={{
              mr: 18,
              display: { xs: "none", md: "flex" },
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            Manage Your Budget!
          </Typography>
          <Box sx={{ flexGrow: 1, display: "flex" }}>
            <Typography
              variant="h6"
              noWrap
              component="a"
              onClick={() => handleNavigation("/home")}
              sx={{
                mr: 4,
                display: { xs: "none", md: "flex" },
                fontFamily: "monospace",
                fontWeight: 700,
                letterSpacing: "0",
                color: "inherit",
                textDecoration: "none",
              }}
            >
              <HomeIcon style={{ fontSize: "150%", marginRight: "0.3rem" }} />{" "}
              Home
            </Typography>
            <Typography
              variant="h6"
              noWrap
              component="a"
              onClick={() => handleNavigation("/profile")}
              sx={{
                mr: 4,
                display: { xs: "none", md: "flex" },
                fontFamily: "monospace",
                fontWeight: 700,
                letterSpacing: "0",
                color: "inherit",
                textDecoration: "none",
              }}
            >
              <HowToRegIcon
                style={{ fontSize: "150%", marginRight: "0.3rem" }}
              />
              Profile
            </Typography>

            <Typography
              variant="h6"
              noWrap
              component="a"
              onClick={() => handleNavigation("/change_password")}
              sx={{
                mr: 4,
                display: { xs: "none", md: "flex" },
                fontFamily: "monospace",
                fontWeight: 700,
                letterSpacing: "0",
                color: "inherit",
                textDecoration: "none",
              }}
            >
              <SettingsSuggestIcon
                style={{ fontSize: "150%", marginRight: "0.3rem" }}
              />
              Settings
            </Typography>

            <Typography
              variant="h6"
              noWrap
              component="a"
              sx={{
                ml: 44,
                display: { xs: "none", md: "flex" },
                fontFamily: "monospace",
                fontWeight: 700,
                letterSpacing: "0",
                color: "inherit",
                textDecoration: "none",
              }}
            >
              <Button
                variant="contained"
                onClick={onClickSignOut}
                style={{ fontFamily: "monospace", fontWeight: 700 }}
              >
                {" "}
                <ExitToAppIcon
                  style={{ fontSize: "150%", marginRight: "0.3rem" }}
                />
                Sign Out
              </Button>
            </Typography>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default Header;
