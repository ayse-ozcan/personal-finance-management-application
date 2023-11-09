import * as React from "react";
import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import { Box } from "@mui/material";

export default function Footer() {
  return (
    <Box
      sx={{
        py: 3,
        px: 2,
        mt: "auto",
      }}
      component="footer"
    >
      <Container maxWidth="sm">
        <Typography variant="body2" color="text.secondary" align="center">
          Made with ❤️ by Ayse Ozcan
        </Typography>
      </Container>
    </Box>
  );
}
