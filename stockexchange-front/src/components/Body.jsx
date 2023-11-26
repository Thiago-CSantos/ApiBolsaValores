/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from "react";
import './Body.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import axios from "axios";
// import { Swiper, SwiperSlide } from 'swiper/react'

// const data = [
//       { id: '1', image: 'https://img.freepik.com/free-photo/happy-businessman-texting-mobile-phone-while-working-laptop-office_637285-794.jpg?w=740&t=st=1700341384~exp=1700341984~hmac=bc79b6dfd4cdf3723e0404b68fc474747bca42a0e8c41bbdac0463435e87d018' },
//       { id: '2', image: 'https://www.shutterstock.com/shutterstock/photos/2104483871/display_1500/stock-photo-portrait-of-a-successful-handsome-businessman-working-on-laptop-computer-in-big-city-office-late-in-2104483871.jpg' }
// http://localhost:8080/v1/finance/price/2023-11-22?symbol=CMIN3.SA
// ]


export default function Body() {

      const [dadosApi, setDadosApi] = useState([]);
      const [valorSymbol, setValorSymbol] = useState('');
      const [valorData, setValorData] = useState('');
      const historicoDados = [];

      const handleSymbol = (evento) => {
            const upperCaseEvento = evento.target.value.toUpperCase();
            setValorSymbol(upperCaseEvento);
      }

      const handleData = (evento) => {
            setValorData(evento.target.value);
      }

      const isValidDate = (dateString) => {
            const regex = /^\d{4}-\d{2}-\d{2}$/;
            return dateString.match(regex) !== null;
      }

      const handleConsultar = async (evento) => {
            evento.preventDefault();

            // Validar a data antes de fazer a chamada da API
            if (!isValidDate(valorData)) {
                  console.log('Data inválida');
                  return;
            }

            const url = `http://localhost:8080/v1/finance/price/${valorData}?symbol=${valorSymbol}.SA`;

            try {
                  const resposta = await axios.get(url);
                  setDadosApi(resposta.data);
                  historicoDados.push(resposta.data)
                  console.log(historicoDados);
            } catch (error) {
                  console.log("Deu errado:", error);
            }
      }

      return (
            <>
                  <main id="home">
                        <section className="you-stock">
                              <h1>Bem-vindo ao YourStocker</h1>
                              <p>
                                    Nosso objetivo é fornecer soluções de consulta suas ações e
                                    fundos imobiliarios  para alcançar seus objetivos financeiros.
                              </p>
                              <form className="pesquisa" onSubmit={handleConsultar}>
                                    <input type="text" name="input-date" id="input-date" placeholder="AAAA-MM-DD" onChange={handleData} />
                                    <input type="text" name="input-symbol" id="input-symbol" placeholder="Simbolo da ação" onChange={handleSymbol} />
                                    <button className='btnLogin' >
                                          consultar
                                    </button>
                              </form>
                        </section>
                        <section className="transaction">
                              <h2>Suas transações</h2>
                              {dadosApi.map((dado, chave) => {
                                    return (
                                          <div key={chave} className="divMap">
                                                <ol>
                                                      <li className="li-symbol"><h4>Symbol: {dado.symbol}</h4></li>
                                                      <li><p><b>Data:</b> {dado.data}</p></li>
                                                      <li><p><b>Abertura:</b> {dado.abertura}</p></li>
                                                      <li><p><b>Máxima:</b> {dado.maxima}</p></li>
                                                      <li><p><b>Minima:</b> {dado.minima}</p></li>
                                                      <li><p><b>Fechamento:</b> {dado.fechamento}</p></li>
                                                      <li><p><b>Volume:</b> {dado.volume}</p></li>
                                                </ol>
                                          </div>
                                    );
                              })}

                        </section>

                  </main>

                  {/* <section className="historico" id="historico">
                        <h1>Histórico de transações</h1>

                        {historicoDados.length === 0 ? (
                              <p>Nenhum histórico disponível</p>
                        ) : (
                              <ol className="ol-historico">
                                    {historicoDados.map((dado, chave) => (
                                          <li key={chave}><p>{dado.data}</p></li>
                                    ))}
                              </ol>
                        )}

                  </section> */}
            </>
      );
}