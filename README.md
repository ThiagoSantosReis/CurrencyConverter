# Aplicação de Conversão de Moedas em Java

## Descrição

Aplicação em Java que realiza conversões entre moedas usando a API ExchangeRate API.  
Os resultados das conversões são salvos em um arquivo JSON para registro histórico.

## Funcionalidades

- Consulta taxas de câmbio atualizadas na API.  
- Converte valores entre moedas.  
- Armazena cada conversão em um arquivo `conversions.json` sem apagar dados anteriores.

## Estrutura

- `entities` — classes de domínio.  
- `utils` — utilitários, como gravação dos registro em JSON.  
- `services` — lógica da conversão e chamadas à API.  
- `controller` — coordena entrada, processamento e saída dos dados.

## Exemplo de saída (`conversions.json`)

```json
[
  {
    "from_currency": "USD",
    "to_currency": "BRL",
    "result": 503.658
  },
  {
    "from_currency": "BRL",
    "to_currency": "ARS",
    "result": 36785.337
  }
]
