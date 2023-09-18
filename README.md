# Procesamiento_Concurrente_Suma_Transacciones_Financieras

Mi repositorio: https://github.com/AnaGarciaDelAlamo/Procesamiento_Concurrente_Sumas_Transacciones_Financieras.git

## Contexto: 
Eres un desarrollador de software en una gran corporación con múltiples departamentos como informática, gerencia, contabilidad, comercio y recursos humanos. Cada departamento realiza varias transacciones financieras diarias, y todas estas transacciones se registran y almacenan en archivos de texto individuales correspondientes a cada departamento.

Dado el volumen de transacciones, la empresa necesita una forma eficiente de procesar y sumar todas las transacciones de cada departamento. Sin embargo, dado que los archivos se actualizan constantemente a lo largo del día, no es posible realizar este procesamiento de forma secuencial, ya que llevaría demasiado tiempo.

Para abordar este desafío, la empresa te ha pedido que desarrolles un programa que pueda procesar y sumar las transacciones de cada archivo de manera concurrente, utilizando el paralelismo de la máquina.

Además, para facilitar la revisión y el análisis posterior, el programa debe generar un archivo de resultados para cada departamento, que contendrá la suma total de las transacciones del respectivo departamento. Por ejemplo, los resultados para el archivo "informatica.txt" se almacenarán en "informatica.txt.res".

Finalmente, para tener una visión completa de las transacciones de toda la empresa, el programa debe sumar todas las sumas de cada departamento y guardar el total en un archivo llamado "Resultado_global.txt".

Debido a la posible magnitud de las transacciones, debes utilizar el tipo de dato long. Además, tu programa debe manejar correctamente las posibles excepciones, como los errores de entrada/salida.

Para organizar tu trabajo, puedes considerar la creación de las siguientes clases:

UtilidadesFicheros: con métodos útiles para el procesamiento de archivos, incluyendo uno para obtener la suma de las transacciones de un conjunto de archivos.

ProcesadorContabilidad: que procesará un archivo, sumará las transacciones y almacenará el resultado en el archivo correspondiente.

Lanzador: que controlará el flujo de la aplicación, lanzando un proceso ProcesadorContabilidad para cada archivo y luego agregando todos los resultados.
Tu programa consistirá en varias clases que pueden estar dispersas en diferentes directorios, por lo que tu método main necesitará tomar el CLASSPATH de los argumentos.

Al final del proyecto, debes entregar el código fuente de tu programa, incluyendo todas las clases necesarias. Esto permitirá a la empresa procesar sus transacciones de manera eficiente, ahorrando tiempo y recursos.
