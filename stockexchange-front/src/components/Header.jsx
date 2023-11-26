// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';
import logo from '../assets/Logo.png';
import './Header.css';

export default function Header() {
  

  const scrollToSection = (sectionId) => {
    const section = document.getElementById(sectionId);
    if (section) {
      section.scrollIntoView({ behavior: 'smooth' });
    }
  };

  return (
    <>
      <header>
        <img src={logo} alt="Logo do banco" />
        <nav>
          <a href="#" onClick={() => scrollToSection('home')}>Home</a>
          {/* <a href="#" onClick={() => scrollToSection('historico')}>Histórico</a> */}
          <a href="#" onClick={() => scrollToSection('contato')}>Contato</a>
        </nav>
        
      </header>
    </>
  );
}
